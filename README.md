# Spring Flash

This CLI app allows you to quickly generate `.java` stubs for your Spring applications. I find it quite tedious to copy-paste entities, controllers, services and then replace all instances from FooController to BarController. This tool will help with that and speed things up!

## Available commands:

- `flash make:entity Foo -p=<package>`
- `flash make:controller Foo -p=<package>`
- `flash make:service Foo -p=<package>`
- `flash make:repository Foo -p=<package>`

Navigate to the root of your Spring project and use this command. Providing the package flag is necessary in order to properly place the generated files.

This project is still in development, but there are no downsides from using it now.

## Tests

_Coming soon._

## Contributions

Contributions to this project are very welcome! Feel free to submit an issue or a pull request.

## License

MIT License