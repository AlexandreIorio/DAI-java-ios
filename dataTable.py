import pandas as pd
import matplotlib.pyplot as plt

# get datas from csv file
data = pd.read_csv('data.csv', delimiter=';')

# Exclude the first column from the data
data_without_first_column = data.iloc[:, 1:]

# Create a table for the data without the first column
data_table = plt.table(cellText=data_without_first_column.values, colLabels=data_without_first_column.columns, cellLoc='center', loc='center')

# Hide the table's axis
data_table.auto_set_font_size(False)
data_table.set_fontsize(10)
data_table.scale(1, 1.5)

# Hide the axes
plt.axis('off')

# Save the figure as SVG
plt.savefig('data_table.svg', format='svg', bbox_inches='tight')

# Show the table
# plt.show()
