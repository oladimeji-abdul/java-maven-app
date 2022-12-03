CODE_CHANGES = getGitChanges
pipeline {
    agent any
    environment {
        NEW_VERSION = '1.0'
       // SERVER_CREDENTIALS = credential('server_credential')
    }
    tools {
        maven 'Maven'
    }
    stages {
        stage("build") {
            steps {
                echo "building stage..."
                echo "building ${NEW_VERSION}"
                sh "mvn install"
            }
        }

        stage("dev") {
            when {
                expression {
                    env.BRANCH_NAME == 'build' || env.BRANCH_NAME == 'test' && CODE_CHANGES == true
                }
            }
            steps {
                echo "dev stage...."
                withCredentials([
                    usernamePassword(credentials: 'server-credential', usernameVarialbe: USER passwordVariable: PWD)
                ]) {
                    sh "script run with ${USER} -p ${PWD}"
                }

            }
        }
    }
