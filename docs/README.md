
# Markdown with com.vladsch.flexmark

## Static Example
This is an example to use markdown with Liferay.
I've create a simple service using com.vladsch.flexmark.

1. Build and deploy the api and the service
1. Enable 'serviceLocator' and 'com.liferay.demo.markdown.service.MarkdownServiceImpl' in System Settings / Template Engines / Freemarker Engine
1. Write an ADT with the following contents:
    ```
    <#assign markdownService = serviceLocator.findService("com.liferay.demo.markdown.api.MarkdownService") />
    ${markdownService.basicrenderer("*Gladiators* from the **past**")}
    ```
1. Add an asset publisher to a page and use the ADT to display
1. If it shows '_Gladiators_ from the **past**' you know it's working and can start using it.
   
 ## Dynamic Example
 ### Using a content structure and template
 
 Example webcontent template
   
   ```
   <!-- example Webcontent item with a field 'Content' -->
   
   <#assign markdownService = serviceLocator.findService("com.liferay.demo.markdown.api.MarkdownService") /> 
   ${markdownService.basicrenderer(Content.getData())}
   ```
   [video](markdown.mp4)  
   ![demo](markdown.gif "screenshot")
