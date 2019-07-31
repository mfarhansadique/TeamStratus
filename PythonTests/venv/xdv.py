from selenium import webdriver
import os
import time



class testone():
    driver = None

    def opening_browser(self):
        driverLocation = "/c ./SeleniumDriver/chromedriver"
        os.environ["webdriver.chrome.driver"] = driverLocation
        self.driver = webdriver.Chrome(driverLocation)
        self.driver.get("http://google.com")
        time.sleep(1)
        inputElement = self.driver.find_element_by_xpath('//*[@id="root"]/div/nav/a[3]/button').click()
        self.driver.maximize_window()




    def input_into_searchbar(self):
     inputElement = self.driver.find_element_by_name('firstname')

     inputElement.send_keys("6666")
     inputElement = self.driver.find_element_by_name('lastname')
     inputElement.send_keys("DaBuilder")
     inputElement = self.driver.find_element_by_name('username')
     inputElement.send_keys("canwefixit4")
     inputElement = self.driver.find_element_by_name('email')
     inputElement.send_keys("bob4@hotmail.com")
     inputElement = self.driver.find_element_by_name('password')
     inputElement.send_keys("password")
     inputElement = self.driver.find_element_by_name('confirmpassword')
     inputElement.send_keys("password")
     inputElement = self.driver.find_element_by_xpath('//*[@id="root"]/div/div/div/form/input[7]').click()
     time.sleep(5)
     self.driver.close()


gc = testone()
gc.opening_browser()
# gc.input_into_searchbar()