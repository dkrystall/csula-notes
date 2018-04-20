geometric :: Double -> Double
geometric 0 = 0
geometric x = 1/x + geometric (x - 1)

geometric2 0 = 0
geometric2 x = x/(x+1) + geometric2 (x-1)

removeMax' [] = []
removeMax' _ = []
removeMax' (x:xa:xs)
    | x > xa removeMax' (xs ++ x)
    | otherwise = removeMax' (xa ++ xs)
