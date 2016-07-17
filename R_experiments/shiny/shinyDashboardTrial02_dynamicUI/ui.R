
# This is the user-interface definition of a Shiny web application.
# You can find out more about building applications with Shiny here:
#
# http://shiny.rstudio.com
#

library(shiny)
library(shinydashboard)

shinyUI(dashboardPage(
  dashboardHeader(title = "Basic dashboard"),
  dashboardSidebar(
    sidebarMenu(
    #  ("appName", "AppName:","appNames"),
      uiOutput("choose_appNames"),
      uiOutput("choose_branch"),
      uiOutput("choose_buildRange"),
      uiOutput("choose_platform"),

      sliderInput("slider", "(Test)Number of observations:", 1, 100, 50)
      
    )
  ),
  dashboardBody(
    fluidRow(
      
      valueBoxOutput("failureRateBox"),
      valueBoxOutput("SessionCountBox"),
      valueBoxOutput("FailureCountBox")
      #valueBox(".004%", "Failur Rate", icon = icon("credit-card")),
      #valueBox(1000000, "Sessions tracked", icon = icon("credit-card")),
      #valueBox(1000, "sessions failed in tracked", icon = icon("credit-card"))
      
      
    ),
    fluidRow(
      box(title = "FailureHashes", background = "maroon", width = 12 , plotOutput("plot1", height = 250))
    ),
    fluidRow(
      box(title = "FailureHashes",width = 12 , dataTableOutput("table1"))
    )
    
  )
)
)
