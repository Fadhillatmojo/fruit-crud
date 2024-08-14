# Fruit API - Spring Boot

This is a simple CRUD API built with Spring Boot for managing fruit data. The API supports basic operations such as creating, reading, updating, deleting, and soft deleting fruit records.

## Introduction
The Fruit API allows you to manage fruit data with operations like adding new fruits, retrieving fruit details, updating fruit information, and deleting (soft delete) records. The API also filters records based on certain criteria like `type` and handles soft deletion by maintaining records with a `deletedAt` timestamp.

## Features
- Create a new fruit record
- Retrieve all fruits
- Retrieve fruits by ID
- Update existing fruit records
- Delete fruit records (soft delete)
- Retrieve only active (non-deleted) fruits
- Filter fruits by type (e.g., "Tropical")

## Requirements
- Java 17 or higher
- Maven 3.8 or higher
- Postgresql
- IDE (e.g., IntelliJ IDEA, Eclipse)
