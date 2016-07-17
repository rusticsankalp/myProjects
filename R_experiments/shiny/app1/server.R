library(shiny)

# Define server logic required to draw a histogram
shinyServer(function(input, output) {
  
  output$text1 <- renderText({ 
    paste("You have selected", input$var)
    
    
    
  })
  
  output$cityControls <- renderUI({
    cities <- c(input$lat, input$long)
    checkboxGroupInput("cities", "Choose Cities", cities)
  })
  
}
)