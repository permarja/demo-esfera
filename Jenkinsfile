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
			
					  /*stage("CESICAT: Anàlisi seguretat dependency check") {
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

					 }*/
				} 
				
				container(name: 'maven') {
					//TODO: Not sure of the real nature of smoke tests
					try{
					stage ('Smoke Test PRE') {
						echo "SmokePRE"
					 	sh "mvn clean install test -Denv.ENTORNO=PRE -Dgroups=SMOKE"
						echo "fi SmokePRE"
					    //TODO: Machaca los surefire-reports
					    //junit healthScaleFactor: 1.0, testResults: 'target/failsafe-reports/TEST*.xml'	
					}
					stage('Acceptance Test PRE') {
						echo "AcceptancePRE"
					    sh "mvn clean install test -Denv.ENTORNO=PRE -Dgroups=ACCEPTANCE" 
					    echo "fi AcceptancePRE"
					}
					}
					finally {
					    publishHTML(target: [
						    reportDir            : 'target',
						    reportFiles          : 'index.html',
						    reportName           : 'OWASP Dependency Check Informe',
						    keepAll              : true,
						    alwaysLinkToLastBuild: true,
						    allowMissing         : false
                            			])
						}
				}
	     }
	 }
