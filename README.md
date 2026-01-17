# PlayerPing

🎯 **PlayerPing** is a lightweight, modern Minecraft plugin for Spigot/Paper servers that lets players ping each other using `@Username` in chat — just like in Discord or other social apps.

Perfect for survival, PvP, and social servers that want to modernize communication and improve team coordination.

## If you want the build dm @wboog on discord

---

## ✨ Features

- ✅ Ping players in chat using `@Username`
- 🎨 Highlights the pinged name in chat with customizable color
- 🔔 Plays a subtle sound to notify the pinged player
- ✨ Optional particles or glow effects when pinged
- 🔧 Fully configurable via `config.yml`
- 🛡️ Anti-spam cooldown and permission support
- 📴 `/pingtoggle` command to opt in/out of pings

---

## 💬 Example

When a player sends:
Hey @Steve, can you help with the base?

- Steve sees their name in **highlighted text**
- Hears a soft notification sound
- Optionally sees a short particle or glow effect

---

## ⚙️ Configuration

```yaml
ping:
  enabled: true
  triggerSymbol: "@"
  highlightColor: "gold"
  sound: "entity.experience_orb.pickup"
  particle: "note"
  allowMultiple: true
  cooldownSeconds: 3
