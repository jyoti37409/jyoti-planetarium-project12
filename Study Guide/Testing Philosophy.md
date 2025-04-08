# Testing Philosophy Study Guide

## Intro to Testing

### Tester vs Developer Mindset
Testers are problem-oriented, concentrating on identifying issues and potential failures in software and the surrounding resources. Their goal is to ensure the application works under various conditions, often thinking about how to break the system to uncover weaknesses and vulnerabilities. They adopt the user’s perspective to test for real-world scenarios and usability, aiming to ensure the software meets quality standards and is free of defects. Their focus is on quality assurance, making sure the final product is reliable and intuitive

Developers are primarily goal-oriented, focusing on building and implementing features that are functional, efficient, and scalable. They approach problems with a solution-focused mindset, always thinking about how to make things work. Attention to detail is crucial for them, as they strive to write clean, efficient code that performs well. They also assess risks in terms of technical challenges, scalability, and performance, ensuring that the software can handle its use demands

Fundamentally, the end goal for both testers and developers is the same: releasing a high quality product that meets the needs of stakeholders. They simply differ in their approach to assisting in the creation of a high quality product

### Quality Management
Despite the terms testing and **quality assurance** (**QA**) often being used synonymously, they are actually distinct concepts. Testing is a form of **quality control** (**QC**) that is product-oriented and corrective, focused on identifying and fixing defects in the product to achieve high levels of product quality. **QA**, on the other hand, is process-oriented and preventive, aiming to improve processes to ensure high quality results. This means that testing itself is a **QC** practice, whereas **QA** involves implementing and improving processes, ensuring that good processes lead to good products. Test results are used in **QC** to fix defects, and in **QA** to provide feedback on process performance

### Verification & Validation
Most testing can be categorized as either **verification** or **validation**. These two categories of tests have different objectives:
- **verification** answers the question "are we building the product correctly?"
- **validation** answers the question "are we building the right product?"

For example, imagine you are on a team that has been tasked with building and testing a bike. **Verification** would involve checking that each component of the bike meets the specified design requirements and standards. This could involve checking the frame is made from the correct material, the brakes are designed properly, the correct number of gears are accommodated in the plan, etc. Essentially, verification is about confirming that the bike is being assembled according to any provided requirements through the use of **static testing**. On the other hand, **validation** would involve testing the bike in real-world conditions to ensure it meets the needs and expectations of the end user. This might include taking the bike for a test ride to confirm it provides a comfortable and safe riding experience, and that it performs well under various conditions such as different terrains and weather. **Validation** ensures that the final product is fit for its intended purpose and satisfies customer requirements through the use of **dynamic testing**.

### Requirements
**Requirements** can vary widely, encompassing business, technical, regulatory, accessibility, and other arbitrary needs. They provide details about what should be included or excluded from a product. These **requirements** can take many forms, although there are some standardized methods for presenting them. Common formats include **software requirement specifications**, **use cases**, **user stories**, and **non-functional specifications**. Each of these formats helps ensure that all necessary aspects of the product are clearly defined and understood by developers, testers, and any other stakeholders

### Defect vs Error vs Failure
A core goal of testing is to discover **defects**: a **defect** is any failed requirement or deviation of an expected outcome. This could be a business **requirement** not being met, a software feature not working correctly, gaining access to resources you are not supposed to, etc. Note that the terms **defect** and "bug" can be used interchangeably, but **defect** is the more formal way of describing deviations from expected results

In software work, any mistake a developer adds to code, whether calling the wrong variable, forgetting to implement a business rule, or any other mistake, is called an **error**. It is **errors** that lead to **defects** being present in code

Anytime a **defect** is executed/triggered in your application it will trigger one or more **failures**. Note that **defects** and **failures** represent the same thing, a deviation from the expected or required. The main difference is in how the **defect** is revealed: **failures** happen when a **defect** is triggered in a active application (this can be user discovered in production or tester discovered in the testing environment) that causes the intended use of the application to deviate from the expected. This means that all **failures** are **defects**, but not all **defects** are **failures**. Some examples of **defects** that are not **failures**:
- aesthetic issues
- sub-par application performance (poor latency, throughput, etc.)
- incorrect documentation
- accessibility optimizations
