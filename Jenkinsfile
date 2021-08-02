pipeline {
    agent any
    tools {
        maven 'M3'
    }
    
    stages {
        stage('Checkout') {
            steps {
                  git branch: 'master', url:'https://github.com/Fahadi1/PackagingWS.git'
					sh 'mvn clean'
                script {
                try {
                sh 'docker stop cpackagingws && docker rm cpackagingws'
                } catch (Exception e) {
                    sh 'echo "---=--- No container to remove ---=---" '
                }
            }
        }
        }
		
		stage('Compile') {
            steps {
                sh 'echo "---=--- Compile ---=---"'
                sh 'mvn -DskipTests clean compile'
            }
        }
        
        
        stage('package'){
            steps {
                sh 'echo "---=--- Package ---=---"'
                sh 'mvn -DskipTests package'
            }
              post {
            always {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        } 
        }
        
        stage('SSH transfert') {
        steps {
            script {
                sshPublisher(publishers: [
                    sshPublisherDesc(configName: 'ec2-host', transfers:[
                        sshTransfer(
                          execCommand: '''
                                echo "-=- Cleaning project -=-"
                                sudo docker stop cpackagingws  || true
                                sudo docker rm cpackagingws || true
                                sudo docker rmi bertromain/packagingws:1.0 || true
                            '''
                        ),
                        sshTransfer(
                            sourceFiles:"target/*.jar",
                            removePrefix: "target",
                            remoteDirectory: "//home//ec2-user",
                            execCommand: "ls /home/ec2-user"
                        ),
                        sshTransfer(
                            sourceFiles:"Dockerfile",
                            removePrefix: "",
                            remoteDirectory: "//home//ec2-user",
                            execCommand: '''
                                cd /home/vagrant;
                                sudo docker build -t bertromain/packagingws:1.0 .; 
                                sudo docker run -d --name cpackagingws -p 8087:8087 bertromain/packagingws:1.0;
                            '''
                        )
                    ])
                ])                
            }
        }
    }
    }
    
}
