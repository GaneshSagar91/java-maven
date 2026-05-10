pipeline{
    agent any
    
    tools{
        maven "maven-3.9.15"
    }
    
    stages{
        stage("Checkout Github"){
            steps{
                git branch: 'main', url: 'https://github.com/GaneshSagar91/java-maven.git'
            }
        }
        stage("Build"){
            steps{
                sh 'ls'
                sh 'mvn clean package'
            }
        }
        stage("Testing"){
            steps{
                sh 'ls'
            }
        }
        stage("Deploying to Dockerhub"){
            environment{
                DOCKERHUB_CREDS = credentials('docker-hub-creds')
                IMAGE_TAG = "$DOCKERHUB_CREDS_USR/java-maven-app:1.$BUILD_NUMBER"
            }
            steps{
                sh '''
                    echo "$DOCKERHUB_CREDS_PSW" | docker login -u "$DOCKERHUB_CREDS_USR" --password-stdin
                    
                    docker build -t $IMAGE_TAG .
                    
                    docker push $IMAGE_TAG
                '''
            }
        }
    }
    
    post{
        always{
            echo "Runs always"
        }
        failure{
            echo "Build Failed"
        }
        success{
            echo "Build Success"
        }
    }
}
