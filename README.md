# Omni

## Overview
A brief description of what this project does and who it's for. Include a high-level explanation of the problem it solves.

## Requirements
List the requirements needed to use the software:
- Java 21

## Installation
```bash
# Clone the repository
git clone git@github.com:0xJas0n/Omni.git

# Navigate to the project directory
cd omni
```

## Usage
Provide examples of how to use your software:

```bash
# Basic usage example
npm start

# Command line arguments (if applicable)
node app.js --option value
```

## API Reference
If your project has an API, provide documentation or link to it.

### Endpoints
* `GET /api/resource` - Description
* `POST /api/resource` - Description

## Database Schema
If applicable, include database schema information or diagrams.

## Architecture
Brief description of the application architecture, possibly with a diagram.

## Testing
```bash
# How to run tests
npm test
```

Run static code analysis locally with the following command.
The host URL is only valid in the FHV Wi-Fi.
```bash
sonar-scanner \
  -Dsonar.projectKey=Omni \
  -Dsonar.sources=src/main \
  -Dsonar.host.url=http://10.0.40.179:9000 \
  -Dsonar.token=sqp_23ff9776568253a0fff47bf5baf75cd7da74a469
```

## Deployment
Instructions for deploying to production environments.

## Contributing
Guidelines for contributing to the project.

1. Create your feature branch (`git checkout -b feature/amazing-feature`)
2. Commit your changes (`git commit -m 'Add some amazing feature'`)
3. Push to the branch (`git push origin feature/amazing-feature`)
4. Open a Pull Request
5. Add the change to [CHANGES.md](./CHANGES.md) using following template
   ```md
   ##### 2025-03-31 0.1.0

   - FEATURE: Description what changed or was added. (#1)
   - BUGFIX: Description what changed or was added. (#2)
   - ENHANCEMENT: Description what changed or was added. (#3)
    ```

## License
MIT License

Copyright © 2025 Omni Development Team

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.