findNext :: Int -> [Int] -> Int
findNext a [ ] = -1
findNext a [_] = -1
findNext a (x:xs)
    | a == x    = (head xs)
    | otherwise = findNext a xs

findPrev :: Int -> [Int] -> Int
findPrev a [ ] = -1
findPrev a [_] = -1
findPrev a (x:xs)
    | x  == a    = -1
findPrev a (x:xa:xs)
    | xa == a   = x
    | xa /= a   = findPrev a (xa:xs)
    | otherwise = -1

digSum :: Int -> Int
digSum 0 = 0
digSum x = (x `mod` 10) + digSum(x `div` 10)

digs :: Integral x => x -> [x]
digs 0 = []
digs x = digs (x `div` 10) ++ [x `mod` 10]
