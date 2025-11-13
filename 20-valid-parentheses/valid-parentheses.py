class Solution:
    def isValid(self, s: str) -> bool:
        close_to_open = {
            ")":"(",
            "}":"{",
            "]":"["
        }

        stack = []
        for bracket in s:
            if bracket in close_to_open:
                if not stack:
                    return False
                top = stack.pop()
                if close_to_open[bracket] != top:
                    return False
            else:
                stack.append(bracket)

        if stack:
            return False
        else:
            return True