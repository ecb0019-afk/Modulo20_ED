import os
import shutil

src_dir = r"C:\Users\Eloix\.gemini\antigravity\scratch\clean-code-project\src\main\java"
before_dir = os.path.join(src_dir, "before")
after_dir = os.path.join(src_dir, "after")
new_main_dir = os.path.join(src_dir, "com", "cleancode")

# 1. Delete 'before' dir
if os.path.exists(before_dir):
    shutil.rmtree(before_dir)

# 2. Create 'com.cleancode'
os.makedirs(new_main_dir, exist_ok=True)

# 3. Move contents of 'after' to 'com.cleancode'
for item in os.listdir(after_dir):
    shutil.move(os.path.join(after_dir, item), new_main_dir)

# 4. Delete empty 'after' dir
os.rmdir(after_dir)

# 5. Fix packages and imports
for root, dirs, files in os.walk(new_main_dir):
    for file in files:
        if file.endswith(".java"):
            filepath = os.path.join(root, file)
            with open(filepath, 'r', encoding='utf-8') as f:
                content = f.read()
            
            content = content.replace("package after.", "package com.cleancode.")
            content = content.replace("import after.", "import com.cleancode.")
            
            with open(filepath, 'w', encoding='utf-8') as f:
                f.write(content)

print("Project consolidated successfully.")
