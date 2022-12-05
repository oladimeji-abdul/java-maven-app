//CODE_CHANGES = getGitChanges
pipeline {
    agent any
    //environment {
    //    NEW_VERSION = '1.0'
       // SERVER_CREDENTIALS = credential('server_credential')
    //}
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
   // tools {
       // maven 'Maven'
   // }

    stages {
        stage("build") {
            steps {
                echo "building stage..."
               // echo "building ${NEW_VERSION}"
                //sh "mvn install"
            }
        }

        stage("dev") {
            when {
                expression {
                    //env.BRANCH_NAME == 'build' || env.BRANCH_NAME == 'test' && CODE_CHANGES == true
                    params.executeTests == true
                }
            }
            steps {
                echo "dev stage...."
                //withCredentials([
                //    usernamePassword(credentials: 'server-credential', usernameVarialbe: USER passwordVariable: PWD)
                //]) {
                //    sh "script run with ${USER} -p ${PWD}"
                }

            }
        }
    }
