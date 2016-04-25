
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
        selectInput("appName", "AppName:",c("Cylinders" = "cyl","Transmission" = "am","Gears" = "gear")),
        selectInput("branch", "Branch:",c("Cylinders" = "cyl","Transmission" = "am","Gears" = "gear")),
        sliderInput("buildRange", "Build Range:", 1, 100, c(25,75)),
        selectInput("platform", "Platform",c("Cylinders" = "cyl","Transmission" = "am","Gears" = "gear")),
        sliderInput("slider", "Number of observations:", 1, 100, 50)
        
      )
    ),
    dashboardBody(
      fluidRow(
        valueBox(".004%", "Failur Rate", icon = icon("credit-card")),
        valueBox(1000000, "Sessions tracked", icon = icon("credit-card")),
        valueBox(1000, "sessions failed in tracked", icon = icon("credit-card"))
        
      ),
      fluidRow(
        box(width = 12 , plotOutput("plot1", height = 250))
      ),
      fluidRow(
        box(width = 12 , dataTableOutput("table1"))
      )

    )
  )
)
