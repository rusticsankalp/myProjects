
# This is the server logic for a Shiny web application.
# You can find out more about building applications with Shiny here:
#
# http://shiny.rstudio.com
#

library(shiny)
library(shinydashboard)

data("iris")

shinyServer(function(input, output) {
  set.seed(122)
  histdata <- rnorm(500)
  
  
  ######################
  output$choose_appNames <- renderUI({
    selectInput("appName", "AppName:",c("Store" = "store","facebook" = "facebook","whatsapp" = "whatsapp"))
  })
  
  output$choose_branch <- renderUI({
    selectInput("branch", "Branch:",c("rs1_release" = "rs1_release","th2_release" = "th2_release","th" = "th"))
  })
  
  output$choose_buildRange <- renderUI({
    sliderInput("buildRange", "Build Range:", 14000, 14500, c(14225,14275))
  })
  
  output$choose_platform <- renderUI({
    selectInput("platform", "Platform",c("desktop" = "desktop","mobile" = "mobile","xbox" = "xbox"))
  })
  
  #####################
  output$failureRateBox <- renderValueBox({
    valueBox(".004%", "Failur Rate", icon = icon("credit-card"))
  })
  
  output$SessionCountBox <- renderValueBox({
    valueBox(1000000, "Sessions tracked", icon = icon("credit-card"))
  })
  
  output$FailureCountBox <- renderValueBox({
    valueBox(1000, "sessions failed in tracked", icon = icon("credit-card"))
  })
  
  
  
  #####################
  
  output$plot1 <- renderPlot({
    data <- histdata[seq_len(input$slider)]
    hist(data)
  
  })
  
  output$plot2 <- renderPlot({
    data <- histdata[seq_len(input$slider)]
    hist(data)
    
    
  })
  
  output$table1 <- renderDataTable({iris
  })
})
