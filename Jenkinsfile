pipeline{
    agent any
        stages{
            stage("Build"){
                steps{
                    sh "mvn -f webproject/POM.xml  -DskipTests clean package" 
                }
            }
            stage("Test"){
                steps{
                    sh "mvn -f webproject/POM.xml test"
                }
            }
            stage("Deploy"){
                steps{
                    deploy adapters: [tomcat9(credentialsId: '8d8af473-0fcb-493d-9314-898d13ccc9bb', path: '', url: 'http://ec2-3-237-186-233.compute-1.amazonaws.com:8080/')], contextPath: 'webprojectNew', war: '**/webproject.war'
                }
                
            }
            
               
    }
}
