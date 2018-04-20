let docsPage = function () {

    this.buttonGettingStarted = element(by.css('aio-nav-menu')).$('[title="A gentle introduction to Angular."]');
    this.buttonTutorial = element(by.css('aio-nav-menu')).$('[title="The Tour of Heroes tutorial takes you through the steps of creating an Angular application in TypeScript."]');
    this.buttonFundamentals = element(by.css('aio-nav-menu')).$('[title="The fundamentals of Angular"]');
    this.buttonTechniques = element(by.css('aio-nav-menu')).$('[title="Techniques for putting Angular to work in your environment"]');
    this.buttonApi = element(by.css('aio-nav-menu')).$('[title="Details of the Angular classes and values."]');
    this.buttonVersionSite = element(by.css('.form-select-menu')).$('[class="form-select-button"]');
    this.buttonHttp = element(by.className('vertical-menu-item level-2 expanded selected'));
    this.fieldSearch = element(by.css('input'));
    this.rightMenuLink = function (name) {
        return element(by.cssContainingText('.toc-list li a', name));

    }
};

module.exports = new docsPage();