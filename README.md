# Advanced CS — Terminal Aquarium Starter

This repository is the starter code for the **Terminal Aquarium** project.

The project is intentionally console-based so that the same Java program runs cleanly in:

- VS Code on your computer
- GitHub Codespaces in a browser
- any terminal with a compatible JDK

No graphics window or forwarded port is required.

## Project Structure

```text
src/
└── aquarium/
    ├── AquariumApp.java
    ├── Aquarium.java
    ├── ReferenceLab.java
    └── creatures/
        ├── SeaCreature.java
        └── Fish.java
```

`SeaCreature` and `Fish` are provided. You will create additional subclasses.

## Run in VS Code

Open the repository folder in VS Code. If the **Extension Pack for Java** is installed, open:

```text
src/aquarium/AquariumApp.java
```

and use the **Run** link above `main`.

You can also use the included PowerShell script on Windows:

```powershell
.\scripts\run.ps1
```

## Run in GitHub Codespaces

From the GitHub repository:

1. Click **Code**.
2. Choose **Codespaces**.
3. Create a codespace.
4. Wait for Java to finish loading.
5. Open the terminal and run:

```bash
bash scripts/run.sh
```

The repository contains `.devcontainer/devcontainer.json`, so new Codespaces use a consistent Java environment.

## Run the Reference Lab

### Windows PowerShell

```powershell
.\scripts\run-reference.ps1
```

### Codespaces / macOS / Linux

```bash
bash scripts/run-reference.sh
```

## Student Starting Tasks

1. Run the starter program before changing anything.
2. Read `SeaCreature.java` and `Fish.java`.
3. Create at least two new `SeaCreature` subclasses.
4. Give the new subclasses different movement behavior and terminal symbols.
5. Add instances of them to the `SeaCreature[] tank` in `AquariumApp.java`.
6. Complete the reference experiments in `ReferenceLab.java`.
7. Commit and push your work regularly.

## Git Rhythm

A good project habit is:

```text
PULL → EDIT → RUN/TEST → STATUS → ADD → COMMIT → PUSH
```

Useful commands:

```bash
git pull
git status
git add .
git commit -m "Describe your change"
git push
```

## What You Are Expected to Understand

You are **not** expected to memorize every line of the menu or terminal drawing code immediately.

Your main review focus is:

- classes and objects
- inheritance
- packages
- `protected`
- method overriding and `@Override`
- arrays containing object references
- polymorphism
- aliasing and reference behavior

The terminal display is provided so you have something visible and interactive to test while reviewing those concepts.
