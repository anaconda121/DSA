class LongPressedName:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        if name == typed: return True
        
        def generate_char_lst(input_str):
            lst = []
            ptr = 0
            prev = input_str[0]
            while ptr < len(input_str):
                cnt = 0
                while ptr < len(input_str) and input_str[ptr] == prev:
                    ptr += 1
                    cnt += 1

                lst.append([cnt, prev])
                if ptr < len(input_str):
                    prev = input_str[ptr]
            
            return lst
            
        name_lst = generate_char_lst(name)
        typed_lst = generate_char_lst(typed)
        
        if len(name_lst) != len(typed_lst): return False
        
        for i in range(len(name_lst)):
            if (typed_lst[i][0] < name_lst[i][0]): return False
            if (name_lst[i][1] != typed_lst[i][1]): return False
        
        return True
