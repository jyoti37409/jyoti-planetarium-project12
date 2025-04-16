# HTML
Hyper Text Markup Language is one of the core building blocks of the internet. Every button you have pressed, every menu you have navigated, every link followed, has had you engaging with some form of HTML. All the fancy frameworks and websites you use, at their core, are built upon HTML

## Elements
All web elements are created in HTML files using HTML tags. These tags can be solo tags or they can be open and closing tags. Take header elements for instance: the h1-h6 elements are meant to be used as headers for sections of your web page. These elements expect you to place text content inside of them between the opening and closing tags. On the other hand, elements like the img element have a single tag in which you adjust the properties of that element to change how it renders content on the page

## Document Object Model
When browsers render HTML content they create something called the Document Object Model: this is a virtualized version of the HTML provided to the browser. The DOM works in a similar fashion to a file system: elements, similar to directories, can contain other elements. 

Example DOM structure:
- HTML element
    - head element
        - meta element 1
        - meta element 2
        - title element
    - body element
        - h1 element
        - h3 element
        - img element

this is similar to a file structure
- src
    - main
        - Java
        - resources
    - test
        - Java
        - resources

## Browser loading elements
When a browser loads HTML and renders it in the DOM it starts from the top of the HTML content and works its way down element by element. If there is an element that takes a long time to render, or if there is some JavaScript that pauses activity on the page, the content that is lower in the HTML file may not render right away and can cause issues in automation software

## Block & Inline elements
Some elements are "block" elements by default: these elements get rendered on their own separate line when the content is loaded. Other elements are "Inline" elements that will be rendered next to other "Inline" elements on the same line. If a Block and Inline element are declared next to one another in the HTML file the block element will render on its own line, the Inline element will not be placed on the same line

Keep in mind that separating elements in your HTML by new lines is not necessary: if multiple elements are declared on the same line of HTML they are rendered in order from left to right

## Parent & Child elements
Anytime you have an element that has open and closing tags that has other elements declared inside of it (think list items in ordered and unordered lists) the element that contains the sub elements is considered the "parent" element and the contained elements are considered the "child" elements. Similarly, any elements that are children elements of the same direct parent are considered "sibling" elements. Any element that is a parent of one or more other parent elements (think the body element that contains an unordered list of list items) treats the sub elements of any direct "children" elements as "descendants".