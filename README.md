# ConvoCLI Client

The ConvoCLI Client is a lightweight command-line application for interacting with the [ConvoCLI Server](https://github.com/sedegah/ConvoCLI-server).
It provides a straightforward terminal interface for sending messages, managing conversations, and testing the server’s REST API.

## Features

* **Interactive CLI** – Send and receive messages directly from your terminal
* **Server Integration** – Communicates with the ConvoCLI server over HTTPS
* **Configurable** – Define server URL, user tokens, and preferences in a single config file
* **Cross-Platform** – Runs on Linux, macOS, and Windows

## Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/sedegah/ConvoCLI-client.git
   cd ConvoCLI-client
   ```

2. **Set up a virtual environment (Python 3.9+)**

   ```bash
   python3 -m venv .venv
   source .venv/bin/activate   # On Windows: .venv\Scripts\activate
   pip install -r requirements.txt
   ```

## Usage

Start the client:

```bash
python -m convoclient
```

Common commands:

```bash
login            # Authenticate with your API key
send "Hello!"    # Send a message to the server
list             # List recent conversations
exit             # Quit the client
```

## Configuration

Create a `.env` file or edit `config.yaml` to specify:

```
SERVER_URL=https://your-server-url
API_KEY=your_api_key_here
```

## Project Structure

```
ConvoCLI-client/
├─ convoclient/
│  ├─ __main__.py      # Entry point
│  ├─ cli.py           # Command parsing
│  ├─ api.py           # REST API wrapper
│  └─ utils.py         # Helper functions
├─ requirements.txt
└─ README.md
```

## Author

Kimathi Elikplim Sedegah
GitHub: [@sedegah](https://github.com/sedegah)

---
