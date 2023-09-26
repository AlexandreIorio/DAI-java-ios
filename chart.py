import pandas as pd
import matplotlib.pyplot as plt

# get datas from csv file
data = pd.read_csv('data.csv', delimiter=';')

# Separate data into 4 groups based on TEXT/BINARY and Buffered (True/False)
text_false_data = data[(data['Type'] == 'TEXT') & (data['Buffered'] == False)]
text_true_data = data[(data['Type'] == 'TEXT') & (data['Buffered'] == True)]
binary_false_data = data[(data['Type'] == 'BINARY') & (data['Buffered'] == False)]
binary_true_data = data[(data['Type'] == 'BINARY') & (data['Buffered'] == True)]
# Creat chart with 8 lines
plt.figure(figsize=(10, 6))
plt.plot(text_false_data['Size'], text_false_data['WTime'], label="Text (Buffered=False)")
plt.plot(text_true_data['Size'], text_true_data['WTime'], label="Text (Buffered=True)")
plt.plot(binary_false_data['Size'], binary_false_data['WTime'], label="Binary (Buffered=False)")
plt.plot(binary_true_data['Size'], binary_true_data['WTime'], label="Binary (Buffered=True)")

plt.plot(text_false_data['Size'], text_false_data['RTime'], label="Text (Buffered=False)")
plt.plot(text_true_data['Size'], text_true_data['RTime'], label="Text (Buffered=True)")
plt.plot(binary_false_data['Size'], binary_false_data['RTime'], label="Binary (Buffered=False)")
plt.plot(binary_true_data['Size'], binary_true_data['RTime'], label="Binary (Buffered=True)")

# Chart configuration
plt.xlabel("Size (bytes)")
plt.ylabel(" Time nanosecondes")
plt.title("Benchmark Java IO writing / reading")
plt.legend()
plt.grid(True)

# Show chart
plt.show()