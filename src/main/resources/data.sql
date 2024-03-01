-- Use the fx_deals database for subsequent operations
USE fx_deals;

-- Insert currency exchange rates into the currency_exchange_rate table
-- These rates define the conversion rates between pairs of currencies
INSERT INTO currency_exchange_rate(from_currency, to_currency, exchange_rate)
VALUES
    -- USD to EUR conversion and vice versa
    ('USD', 'EUR', 0.88),
    ('EUR', 'USD', 1.14),
    
    -- USD to JPY conversion
    ('USD', 'JPY', 113.50),
    
    -- EUR to JPY conversion
    ('EUR', 'JPY', 126.33),
    
    -- GBP to USD conversion and vice versa
    ('GBP', 'USD', 1.36),
    ('USD', 'GBP', 0.73),
    
    -- AUD to USD conversion and vice versa
    ('AUD', 'USD', 0.71),
    ('USD', 'AUD', 1.41),
    
    -- USD to CAD conversion and vice versa
    ('USD', 'CAD', 1.25),
    ('CAD', 'USD', 0.80),
    
    -- EUR to GBP conversion and vice versa
    ('EUR', 'GBP', 0.83),
    ('GBP', 'EUR', 1.20);
