from selenium import webdriver
import os
import time



class testone():
    driver = None

    def opening_browser(self):
        driverLocation = "./SeleniumDriver/chromedriver"
        os.environ["webdriver.chrome.driver"] = driverLocation
        self.driver = webdriver.Chrome(driverLocation)
        self.driver.get("https://github.com/login")
        time.sleep(1)
     # inputElement = self.driver.find_element_by_xpath('//*[@id="root"]/div/nav/a[3]/button').click()
        self.driver.maximize_window()




    def input_into_searchbar(self):
     inputElement = self.driver.find_element_by_name('login')
     inputElement.send_keys("mfarhansadique")
     inputElement = self.driver.find_element_by_name('password')
     inputElement.send_keys("Thegreentree321")
     inputElement = self.driver.find_element_by_name('commit').click()
     time.sleep(5)
     self.driver.close()


gc = testone()
gc.opening_browser()
gc.input_into_searchbar()