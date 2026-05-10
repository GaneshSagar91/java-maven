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
        stage("Deploying to AWS ECR"){
            environment{
                AWS_ACC_ID = credentials('aws-account-id')
                AWS_REGION = "ap-south-1"
            }
            steps{
                sh '''
                    AWS_ECR_URI="$AWS_ACC_ID.dkr.ecr.$AWS_REGION.amazonaws.com"
                    IMAGE_TAG="$AWS_ECR_URI/ganeshsagar/java-maven-app:1.$BUILD_NUMBER"
                    
                    aws ecr get-login-password --region $AWS_REGION | \
                    docker login --username AWS --password-stdin $AWS_ECR_URI
                    
                    docker build -t $IMAGE_TAG .
                    docker push $IMAGE_TAG
                '''
            }
        }
       /* 
       stage("Deploying to Dockerhub"){
            environment{
                DOCKERHUB_CREDS = credentials('docker-hub-creds')
            }
            steps{
                sh '''
                    IMAGE_TAG="$DOCKERHUB_CREDS_USR/java-maven-app:1.$BUILD_NUMBER"
                    
                    echo "$DOCKERHUB_CREDS_PSW" | \
                    docker login -u "$DOCKERHUB_CREDS_USR" --password-stdin
                    
                    docker build -t $IMAGE_TAG .
                    
                    docker push $IMAGE_TAG
                '''
            }
        } 
        */
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
