# **Store-locator**

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/71db39a2184845d9b9873484eedcbfe2)](https://app.codacy.com/manual/mohamedibrahim-java/store-locator?utm_source=github.com&utm_medium=referral&utm_content=mohamedibrahim-java/store-locator&utm_campaign=Badge_Grade_Settings)

[![Build Status](https://travis-ci.org/mohamedibrahim-java/store-locator.svg?branch=master)](https://travis-ci.org/mohamedibrahim-java/store-locator.svg?branch=master)

application that shows the 5 closest stores to a given position.

## **Requirements**

Create an application that shows the 5 closest Jumbo stores to a given position.
You can find a list of Jumbo stores in JSON format attached to this document.

There are just a few rules:

* it has to be a Java application.What frameworks,libraries you use etc is up to you.
* It has to be a web application.We would like to see at least an API,having an HTML/Javascript frontend is a nice to have.
* Write your code as if it’s production code as much as possible.
* Make sure the reviewer can easily run the application for evaluation purposes.
  
# **Solution Architecture Overview**

# **Functional services**

**Stores Locator service**

Purpose: retrieve store details and register/update store data.

| Method | Path           | Description                           | User authenticated | Available from UI |
|--------|----------------|---------------------------------------|--------------------|-------------------|
| GET    | /stores        | Get all stores near by given location |                    |                   |
| GET    | /stores/all    | Get all stores data                   |                    |                   |
| POST   | /stores/       | Crate/Update stores data              |                    |                   |

# **Application Swagger-UI**
<p align="center">
<img src="https://github.com/mohamedibrahim-java/store-locator/blob/master/img/store-locator-url.png" width="800">
</p>

<p align="center">
<img src="https://github.com/mohamedibrahim-java/store-locator/blob/master/img/store-locator-model.png" width="800">
</p>

# **Application Overview**

<p align="center">
<img src="https://github.com/mohamedibrahim-java/store-locator/blob/master/img/store-locator-allow.png" width="800">
</p>

<p align="center">
<img src="https://github.com/mohamedibrahim-java/store-locator/blob/master/img/store-locator-find.png" width="800">
</p>

# **DevOps Overview**

One of the vital practices in software development lifecycle is DevOps which is mainly designed to building and delivering software products in a more rapidly and reliability fashion.

It simplifies provisioning and managing infrastructure deploying application code, automate software release processes as well as monitoring the application and infrastructure performance.

Here is an example of what we are going to follow to produce our product in an automation way:

1) Pushing code base in GitHub as the centralized code repository which offers multiple benefits: collaboration, backup, security and more.
2) Travis CI which works automatically as a backbone of CI/CD.
3) Codecov/SonarQube playing a role of empowering code reliability, security, and maintainability along with incentivizing developers to write tests and increase code coverage.
4) Docker/DockerHub which is being used widely as the main platform for digital transformation by enabling organizations to seamlessly build, share and run an application by packaging software into standardized units for shipment and deployment.
5) AWS will be used as the main cloud provider that offers reliable and scalable computing services in the cloud at affordable prices.

<p align="center">
<img src="https://github.com/mohamedibrahim-java/store-locator/blob/master/img/automation.jpg" width="800">
</p>

<p align="center">
<img src="https://github.com/mohamedibrahim-java/store-locator/blob/master/img/dockerhub.png" width="800">
</p>

<p align="center">
<img src="https://github.com/mohamedibrahim-java/store-locator/blob/master/img/travisci.png" width="800">
</p>
