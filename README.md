## About Calculator

The simple GUI calculator app that is made for educational purposes.

It supports some basic functions:
- addition, subtraction, multiplication, division;
- squaring;
- calculating the square root;
- calculating the reciprocal number (multiplicative inverse);
- calculating percents.

In addition, the calculator has a number of additional features:
- keeps a single-cell memory;
- keeps a history of operations (their order may be confugured in "Settings" dialog);
- allows to choose a scale and a rounding mode;
- has sound (optional);
- all buttons has a shortcut so it is possible to use all functions without mouse;
- allows to choose a language (english/russian).

## Versions

- 0.1.1: first published version. There are some known issues that need to be fixed.

## Overview

Main window:<br/>
![main_window](/src/main/resources/screenshots/main_window.png)

Settings:<br/>
![settings](/src/main/resources/screenshots/settings.png)

Operations history:<br/>
![history](/src/main/resources/screenshots/history.png)

Shortcuts:<br/>
![help](/src/main/resources/screenshots/help.png)

## Known issues

- [ ] After "Equals" button has been pressed the operation in a history displayed twice
- [ ] After "Equals" button has been pressed the squaring, calc reprocal number and calc the square root functions change the right operand instead of result

## Development plan

- [ ] Reorder the project structure to keep it in line with MVC architectural pattern
- [ ] Add tests
- [ ] Reordering classes: allocate arithmetic operations to the "engine" and add memory and history operations to it

## Credits

The following images from third-party resources were used:

1. <a target="_blank" href="https://icons8.com/icon/53529/calculator">Calculator</a> icon by <a target="_blank" href="https://icons8.com">Icons8</a><br>
2. <a target="_blank" href="https://icons8.com/icon/47576/broom">Broom</a> icon by <a target="_blank" href="https://icons8.com">Icons8</a>
