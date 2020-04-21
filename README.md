# Punycode Converter

Converts internationalized domain names (IDN) from Punycode to ASCII or the other way around.

See also:
- https://en.wikipedia.org/wiki/Internationalized_domain_name
- https://en.wikipedia.org/wiki/Punycode

## Requirements

- JDK 8

## How to run

- Configure a list of domain names to convert from ASCII to Unicode in `/src/main/resources/input-ascii-to-unicode.txt`. E.g.:
    ```
    xn--bcher-kva.example
    xn--bcher-kva.example
    xn--bcher-kva.example
    ```
- Configure a list of domain names to convert from Unicode to ASCII in `/src/main/resources/input-unicode-to-ascii.txt`. E.g.:
    ```
    bücher.example
    bücher.example
    bücher.example
    ```
- Execute the main method of class `PunicodeConverter`.
- A file `/output-ascii-to-unicode.txt` will be created, which lists the domain names converted from ASCII to Unicode.
    ```
    bücher.example
    bücher.example
    bücher.example 
    ```
- A file `/output-unicode-to-ascii.txt` will be created, which lists the domain names converted from Unicode to ASCII.
    ```
    xn--bcher-kva.example
    xn--bcher-kva.example
    xn--bcher-kva.example
    ```

## License

[MIT](LICENSE)

## Author Information

Created by [Philippe Bößling](https://www.gihub.com/pboessling).