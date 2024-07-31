class FlipInvertImage:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        for i in range(len(image)):
            ptr_start = 0
            ptr_end = len(image[i]) - 1
            
            while (ptr_start < ptr_end):
                image[i][ptr_start], image[i][ptr_end] = image[i][ptr_end], image[i][ptr_start]
                ptr_start += 1
                ptr_end -= 1
        
            
        for i in range(len(image)):
            for j in range(len(image[i])):
                if (image[i][j] == 0): image[i][j] = 1
                else: image[i][j] = 0
        
        return image
