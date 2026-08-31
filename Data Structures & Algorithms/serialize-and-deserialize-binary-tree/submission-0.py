# Definition for a binary tree node.
# class TreeNode:
#     def __init__(Deque, self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Codec:

    def serialize(self, root):
        if not root:
            return ""

        result = []
        queue = deque([root])

        while queue:
            node = queue.popleft()

            if node is None:
                result.append("N")
                continue

            result.append(str(node.val))

            queue.append(node.left)
            queue.append(node.right)

        return ",".join(result)

    def deserialize(self, data):
        if not data:
            return None

        values = data.split(",")
        root = TreeNode(int(values[0]))

        queue = deque([root])
        i = 1

        while queue:
            node = queue.popleft()

            # Left child
            if values[i] != "N":
                node.left = TreeNode(int(values[i]))
                queue.append(node.left)

            i += 1

            # Right child
            if values[i] != "N":
                node.right = TreeNode(int(values[i]))
                queue.append(node.right)

            i += 1

        return root