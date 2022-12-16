
import matplotlib.pyplot as plt
import numpy as np
# Initial velocity
v = int(input("Enter Initial Velocity:"))

# Initial angle

theta = np.pi/4

# Acceleration due to gravity
g = 9.8

# Time
end_time=int(input("Enter end time:"))
t = np.arange(0,end_time,0.1)
np.arange

# x and y components of velocity
X = v * np.cos(theta)
Y = v * np.sin(theta)

# Position of the particle
x = X*t
y = (Y*t) - (0.5*g*t*t)
# Plot the trajectory
plt.plot(x,y)
plt.xlabel('DISTANCE')
plt.ylabel('HEIGHT')
plt.title('PROJECTILE MOTION')
plt.show()