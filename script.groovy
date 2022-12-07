def buildAppjar() 

{
    echo "building jar file"
    sh 'mvn package'
    
}

def buildImage() 

{
    echo "building docker image"
    withCredentials([usernamePassword(credentialsId: 'Docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker build -t 698834/demo-app:jma-3.0 .'
    sh "docker login -u $USER -p $PASS"
    sh 'docker push 698834/demo-app:jma-3.0'
    }

}

def deployApp()

{
    echo "deploying app"

}
return this