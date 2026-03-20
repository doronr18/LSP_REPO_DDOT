<!-- TaskManager Collaboration Explanation
Author: Doron Reid
 -->

TaskManager collaborates with Task because its responsibilities include storing tasks, adding new tasks, finding tasks by ID, and returning tasks by status. To perform these responsibilities, TaskManager must interact with Task objects, accessing their details and status. However, Task does not collaborate with TaskManager because its responsibilities are self-contained. It only stores and manages its own information and status, without needing to know about the collection of tasks or how they are managed.