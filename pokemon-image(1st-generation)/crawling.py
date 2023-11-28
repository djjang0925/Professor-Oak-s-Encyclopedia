import urllib.request
import urllib
import time
import sys
import os

from bs4 import BeautifulSoup

from selenium import webdriver
from selenium.webdriver.chrome.service import Service

# 웹드라이버 옵션 설정
webdriver_options = webdriver.ChromeOptions()

# 웹드라이버 서비스 설정
webdriver_service = Service("./chromedriver")

# 웹드라이버 생성
browser = webdriver.Chrome(service=webdriver_service, options=webdriver_options)

browser.maximize_window()

url = "https://www.pokemonkorea.co.kr/pokedex"
browser.get(url)

interval = 2
cnt = 0

prev_height = browser.execute_script("return document.body.scrollHeight")

while True:
    browser.execute_script("window.scrollTo(0, document.body.scrollHeight)")
    time.sleep(interval)
    curr_height = browser.execute_script("return document.body.scrollHeight")

    cnt += 1

    if cnt == 12:
        break
    

prev_height = curr_height
print("스크롤 끝")

soup = BeautifulSoup(browser.page_source, 'html.parser')
pokemons = soup.select('.img-fluid')

print("이미지 url 저장 완료")

f_dir = '/Users/patrick/Desktop/poke/pokemon'
os.chdir(f_dir)

file_no = 1

for pokemon in pokemons:
    urllib.request.urlretrieve(pokemon['src'], str(file_no)+'.png')
    file_no += 1
    time.sleep(0.5)
    print(f'~~~~~~~~~~~~~~~{file_no}번 이미지 저장중~~~~~~~~~~~~~~~~')

print("done")
