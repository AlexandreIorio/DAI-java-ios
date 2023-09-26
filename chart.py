import pandas as pd
import matplotlib.pyplot as plt

# get datas from csv file
data = pd.read_csv('data.csv', delimiter=';')

# Separate data into 4 groups based on Buffered (True/False)
buffered_data = data[data['Buffered'] == True]
not_buffered_data = data[data['Buffered'] == False]

# Create 2 separate charts for Buffered and Not Buffered data
plt.figure(figsize=(12, 6))

# Chart 1: Buffered
plt.subplot(1, 2, 1)
plt.plot(buffered_data[buffered_data['Type'] == 'TEXT']['Size'], buffered_data[buffered_data['Type'] == 'TEXT']['WTime'], label="Write Text buffered")
plt.plot(buffered_data[buffered_data['Type'] == 'BINARY']['Size'], buffered_data[buffered_data['Type'] == 'BINARY']['WTime'], label="Write Binary buffered")
plt.plot(buffered_data[buffered_data['Type'] == 'TEXT']['Size'], buffered_data[buffered_data['Type'] == 'TEXT']['RTime'], label="Read Text buffered")
plt.plot(buffered_data[buffered_data['Type'] == 'BINARY']['Size'], buffered_data[buffered_data['Type'] == 'BINARY']['RTime'], label="Read Binary buffered")

plt.xlabel("Size (bytes)")
plt.ylabel("Time [ms]")
plt.title("Buffered Data")
plt.legend()
plt.grid(True)

# Chart 2: Not Buffered
plt.subplot(1, 2, 2)
plt.plot(not_buffered_data[not_buffered_data['Type'] == 'TEXT']['Size'], not_buffered_data[not_buffered_data['Type'] == 'TEXT']['WTime'], label="Write Text not buffered")
plt.plot(not_buffered_data[not_buffered_data['Type'] == 'BINARY']['Size'], not_buffered_data[not_buffered_data['Type'] == 'BINARY']['WTime'], label="Write Binary not buffered")
plt.plot(not_buffered_data[not_buffered_data['Type'] == 'TEXT']['Size'], not_buffered_data[not_buffered_data['Type'] == 'TEXT']['RTime'], label="Read Text not buffered")
plt.plot(not_buffered_data[not_buffered_data['Type'] == 'BINARY']['Size'], not_buffered_data[not_buffered_data['Type'] == 'BINARY']['RTime'], label="Read Binary not buffered")

plt.xlabel("Size (bytes)")
plt.ylabel("Time [ms]")
plt.title("Not Buffered Data")
plt.legend()
plt.grid(True)

# Adjust layout
plt.tight_layout()

# Save the figure as SVG
plt.savefig('chart.svg', format='svg', bbox_inches='tight')

# Show the charts
# plt.show()
