pipeline {
    agent any
    tools {
        maven 'maven-3.8'
    }
    stages {

        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("build jar") {
            steps {
                script {
                    gv.buildAppjar()
                }

            }
        }
        stage("build image") {
            steps {
                script {
                    gv.buildImage()
                }

            }

   
        }
        stage("app deploy") {
            steps {
                script {
                    gv.deployApp()
                }

            }
        }
    }
}
    
