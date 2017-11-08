#!usr/bin/groovy
@Library('github.com/mostrovoi/pipeline-library@master') _


demoCanigoTemplate(label: 'maven-and-docker-and-kubectl')  { 	
			node('maven-and-docker-and-kubectl') {
				container(name: 'maven') {
					stage("Checkout") {
						checkout scm
					}
					
					stage("Build") {
					    sh "mvn clean package -Denv.ENTORNO=PRE -Dgroups=SMOKE -Dmaven.test.failure.ignore"
					    //TODO: Change to publish html
					    //junit healthScaleFactor: 1.0, testResults: 'target/surefire-reports/TEST*.xml'	
					}
			   
					stage ('Anàlisi de codi estàtic') {
						withSonarQubeEnv("SonarQubeServer") {
						    sh "mvn sonar:sonar -Dsonar.host.url=$SONAR_HOST_URL" 
					    }
					} 

					//TODO: Moure fora del node, no cal un executor assignat
					stage("Validació de SonarQube Gatekeeper") {
						timeout(time: 5, unit: 'MINUTES') { 
							def qG = waitForQualityGate()
							if(qG.status == 'OK')
							  echo "SONAR: Codi acompleix els mínims de qualitat. Enhorabona!"
							else
								error "SONAR: Codi no acompleix els mínims de qualitat : ${qG.status}"
					   }
					}		
		
				  stage("CESICAT: Anàlisi seguretat dependency check") {
                   try {
                            sh "mvn verify -Powasp-dependencycheck,dev"
                        }
                        finally {
                            publishHTML(target: [
                                    reportDir            : 'target',
                                    reportFiles          : 'dependency-check-report.html',
                                    reportName           : 'OWASP Dependency Check Informe',
                                    keepAll              : true,
                                    alwaysLinkToLastBuild: true,
                                    allowMissing         : false
                            ])
						}

				 }
			} 
				
				container(name: 'docker') {
					stage ('Generació imatge docker') {
						 sh("docker build -t gencat.azurecr.io/demo-canigo:latest -f src/assembly/docker/app/Dockerfile .")
					}						   	
	
					stage ('Pujar imatge docker al nostre registre') {
						withCredentials([usernamePassword(credentialsId: 'azureRegistryId', passwordVariable: 'REGISTRY_PASSWORD', usernameVariable: 'REGISTRY_USERNAME')]) { 
						  sh("docker login -u ${REGISTRY_USERNAME} -p ${REGISTRY_PASSWORD} gencat.azurecr.io")
						  sh("docker push gencat.azurecr.io/demo-canigo:latest")
						}
					}						   	
				}

			   
			  	//TODO: Externalitzar valors
				container(name: 'clients') {
					stage ('Desplegament INT') {
						deployProject{
							stagedProject = 'demo-canigo:latest'
						    resourceLocation = 'src/assembly/kubernetes/kubernetes-dev.yaml'
						    environment = 'dev'
							registry = 'gencat.azurecr.io'
						}
					}
				} 

				container(name: 'maven') {
					//TODO: Not sure of the real nature of smoke tests
					stage ('Smoke Test INT') {
					 	sh "clean install test -Denv.ENTORNO=PRE -Dgroups=SMOKE"
					    //TODO: Machaca los surefire-reports
					    //junit healthScaleFactor: 1.0, testResults: 'target/failsafe-reports/TEST*.xml'	
					}
					stage('Acceptance Test INT') {
					     sh "clean install test -Denv.ENTORNO=PRE -Dgroups=SMOKE,ACCEPTANCE" 
					}
					stage ('CESICAT: Anàlisi seguretat amb ZAP') {
                            try {
                                sh "mvn -Powasp-zap,dev verify"
                            }
                            finally {
                                //archiveArtifacts artifacts: '*/target/zap-reports/*.xml'
                                publishHTML(target: [
                                        reportDir            : 'target/zap-reports',
                                        reportFiles          : 'zapReport.html',
                                        reportName           : 'ZAP Report',
                                        keepAll              : true,
                                        alwaysLinkToLastBuild: true,
                                        allowMissing         : false
                                ])
							}
					}
				}
				
				container(name: 'clients') {
					stage ('Desplegament PRE') {
						deployProject{
							stagedProject = 'demo-canigo:latest'
						    resourceLocation = 'src/assembly/kubernetes/kubernetes-pre.yaml'
						    environment = 'pre'
							registry = 'gencat.azurecr.io'
						}
					}
				} 

				container(name: 'maven') {
					stage ('Smoke Test PRE') {
						sh "mvn verify -PsmokeTest,pre -Dserver.url=http://bookstore.pre.matxa.es"
					}
					stage ('Acceptance Test PRE') { 
					 	sh "mvn verify -PintegrationTest,pre -Dserver.url=http://bookstore.pre.matxa.es" 
					}
				} 
				container(name: 'performance') {
					stage('Capacity TEST PRE') {
       					 sh "bzt src/test/jmeter/simple-assert.yml -o settings.artifacts-dir=artifacts"
					}

				}

				stage ('Exploratory Test PRE') {
					echo "Exploratory Test PRE"
					input 'Vols promocionar el build a pro?'
				}

				container(name: 'clients') {
					stage ('Desplegament PRO') {
						deployProject{
							stagedProject = 'demo-canigo:latest'
						    resourceLocation = 'src/assembly/kubernetes/kubernetes.yaml'
						    environment = 'pro'
							registry = 'gencat.azurecr.io'
						}
					}   
				 } 

				container(name: 'maven') {
					stage ('Generació Tag DEFINITIU') {
						echo "Generació Tag DEFINITIU"
						//No cal contemplar-ho, ja ho ha fet l'Arnau
						//Molt similar a generació tag intermig
					}

					stage ('Smoke Test PRO') {
						sh "mvn verify -PsmokeTest,pre -Dserver.url=http://bookstore.matxa.es"
					}
				} 

				stage("Arxivar artefactes") {
					archiveArtifacts artifacts: 'target/**/*'
				 }
	     }
	 }
