# NEUProjects
This Repository contains final projects for Big-data(Hadoop MapReduce code) and Web Tools and Development(Spring MVC).

# FinalProject_Big-data 
Dataset: HealthInsurance Marketplace
Link: https://www.kaggle.com/hhs/health-insurance-marketplace

MapReduce codes to perform following Analysis:
1. Distinct health plans across the states
2. Inverted Index to find out the most commonly words occurring in the file. It will speed up the search process for these words.
3. Min and Max analysis is done to find out how plan rates vary across different states for different age groups. 
   What are the maximum and minimum rates considering the age groups?
4. Moving average for health plans over the months of Rate effective date
5. Mean and Standard Deviations of individual rates of health plans is calculated to get the beneficial plans.
6. Secondary Sorting to sort the values coming to the Reducer of Hadoop Map/Reduce job by using combination of composite key, Partitioner and Writable
   Comparator created using plan ID, rating area, Tobacco preference, age -groups and rate
7. Reduce-Side Join to find out which service areas (combination of state and zip code) provide which health plans, do they cover 
   entire state, Is MarketCoverage Individual or Small Group and is the Source in that network provide DentalOnlyPlans?
8. Partitioning and Binning to perform Data filtering patterns to separate out the palns coverage across each US state.
9. Bloom Filter To filter out for some specific benefits of plan. Here, I have find out what plans cover Accidental Dental Benefits, 
   Routine Dental Services (Adult) and Basic Dental Care - Child.
Also checked top 10 beneficial plans according to number of beenfit they offer.



# FinalProject_SpringMVC
Online Pet Store Application

Developed an interactive application based on Spring MVC framework provide features to buy different species of pets based on customers preferences. 
Application has an option to provide healthcare services, accessories and food for the pets. Application maintains user accounts, 
where they can add and purchase their products. 
Roles: Admin, customer and Service providers (Health service provider)/Doctors

The application has a  marketplace for pets’ accessories where seller can sell their respective products. Customers can deal with 
service providers for their respective issues/services related to pets.

Implemented JSP filters to sanitize user inputs separately on client-side and server-side.


