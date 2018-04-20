let docsPage = require('./docs_page.js');

describe('test https://angular.io/docs', function () {
    beforeEach(function () {
        browser.get('https://angular.io/docs');
    });

    it('Open https://angular.io/docs', function () {
        expect(browser.getCurrentUrl()).toContain('https://angular.io/docs');
        expect(docsPage.buttonGettingStarted.getText()).toEqual('GETTING STARTED');
        expect(docsPage.buttonTutorial.getText()).toEqual('TUTORIAL');
        expect(docsPage.buttonFundamentals.getText()).toEqual('FUNDAMENTALS');
        expect(docsPage.buttonTechniques.getText()).toEqual('TECHNIQUES');
        expect(docsPage.buttonApi.getText()).toEqual('API');
        expect(docsPage.buttonVersionSite.getText()).toEqual('stable (v5.2.10)');

    });
    it('Test serch', function () {
        docsPage.fieldSearch.sendKeys('http');
        browser.sleep(10000);
        element.all(by.className('search-area ng-star-inserted')).then(function (array) {
            expect(array.length).toBe(4);
        })
    });

    it('Negative test serch', function () {
        element(by.css('input')).sendKeys('http1');
        browser.sleep(10000);
        element(by.css('[class="search-results"]')).$('[class="ng-star-inserted"]').getText().then(function (text) {
            expect(text).toEqual('No results found.');
        })
    });

    it('Click on Home', function () {
        element(by.className('nav-link home')).click();
        expect(browser.getCurrentUrl()).toBe('https://angular.io/');
    });

    it('Click on Featers', function () {
        element(by.cssContainingText('.nav-link', 'Features')).click();
        expect(browser.getCurrentUrl()).toBe('https://angular.io/features');
        // browser.sleep(10000);
    });

    it('Click on Docs', function () {
        element(by.cssContainingText('.nav-link', 'Docs')).click();
        expect(browser.getCurrentUrl()).toBe('https://angular.io/docs');
        // browser.sleep(10000);
    });

    it('Click on Resurses', function () {
        element(by.cssContainingText('.nav-link', 'Resources')).click();
        expect(browser.getCurrentUrl()).toBe('https://angular.io/resources');
        // browser.sleep(10000);
    });

    it('Click on Events', function () {
        element(by.cssContainingText('.nav-link', 'Events')).click();
        expect(browser.getCurrentUrl()).toBe('https://angular.io/events');
    });

    it('Click on Blog', function () {
        element(by.cssContainingText('.nav-link', 'Blog')).click();
        browser.ignoreSynchronization = true;
        expect(browser.getCurrentUrl()).toBe('https://blog.angular.io/');
        browser.ignoreSynchronization = false;
    });

    it('Click on Docs menu', function () {
        element(by.className('hamburger mat-button')).click();
        element(by.css('mat-sidenav-content')).getAttribute('style').then(function (attr) {
            expect(attr).toBe('margin-left: 0px; margin-right: 0px;');
        });
        element(by.className('hamburger mat-button')).click();
        element(by.css('mat-sidenav-content')).getAttribute('style').then(function (attr) {
            expect(attr).toBe('margin-left: 268px; margin-right: 0px;');
        });
    });

    xit('Test link "8.HTTP"', function () {//тест не работает, почемуто не находит объект
        docsPage.buttonTutorial.click();
        docsPage.buttonHttp.click();
        expect(browser.getCurrentUrl()).toEqual('https://angular.io/tutorial/toh-pt6');
    });

    xit('Test right menu', function () {//тест не работает, ошибка: элемент невидим
        browser.get('https://angular.io/tutorial/toh-pt6');
        docsPage.rightMenuLink('Heroes and HTTP').click();
        //тест не дописан
    });

    xit('Test go to the corresponding paragraph', function () {//анологичная ошбка как у теста: 'Test right menu'

        browser.get('https://angular.io/tutorial/toh-pt6');
        element(by.css('#enable-http-services a')).click();
        expect(browser.getCurrentUrl()).toEqual('https://angular.io/tutorial/toh-pt6#enable-http-services');
        //тест не дописан

    })

});