ConvoCLI – Client

A lightweight command-line client for interacting with the ConvoCLI Server
.
This client provides a simple, terminal-based interface for sending messages, managing conversations, and testing the server’s REST API.

 Features

Interactive CLI – Send and receive messages directly from your terminal.

Server Integration – Communicates with the ConvoCLI server over HTTPS.

Configurable – Set the server URL, user tokens, and preferences via a single config file.

Cross-platform – Works on Linux, macOS, and Windows.

 Installation
1️ Clone the Repository
git clone https://github.com/sedegah/ConvoCLI-client.git
cd ConvoCLI-client

2️ Set Up a Virtual Environment (Python 3.9+)
python3 -m venv .venv
source .venv/bin/activate   # Windows: .venv\Scripts\activate
pip install -r requirements.txt

Usage

Start the client:

python -m convoclient


Available commands (examples):

login          # Authenticate with your API key
send "Hello!"  # Send a message to the server
list           # List recent conversations
exit           # Quit the client

Configuration

Create a .env file or edit config.yaml to set:

SERVER_URL=https://your-server-url
API_KEY=your_api_key_here

Project Structure
ConvoCLI-client/
├─ convoclient/
│  ├─ __main__.py      # Entry point
│  ├─ cli.py           # Command parsing
│  ├─ api.py           # REST API wrapper
│  └─ utils.py         # Helper functions
├─ requirements.txt
└─ README.md


Author: Kimathi Elikplim Sedegah
GitHub: @sedegah
