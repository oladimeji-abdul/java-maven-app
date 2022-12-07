pipeline {
    agent any
    tools {
        maven 'maven-3.8'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building jar file"
                    sh 'mvn package'
                }

            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building docker image"
                    withCredentials([usernamePassword(credentialsId: 'Docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t 698834/demo-app:jma-3.0 .'
                        sh "echo PASS | docker login -u $USER --password-stdin"
                        sh 'docker push 698834/demo-app:jma-3.0'
                    }
                }
            }

   
        }
        stage("app deploy") {
            steps {
                script {
                    echo "deploying app"
                }

            }
        }
    }

    
}