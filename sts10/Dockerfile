# Dockerfile

# MySQL 이미지를 기반으로 이미지 생성
FROM openjdk:17-jdk-alpine

# MySQL 설정
# ENV MYSQL_ROOT_PASSWORD=mysql
COPY ./target/ /gimhae
CMD [ "java -jar /gimhae/sts10-0.0.1-SNAPSHOT.jar" ]

# 포트 설정 (기본 MySQL 포트는 3306)
EXPOSE 8080