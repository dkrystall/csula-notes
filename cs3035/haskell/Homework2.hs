import Data.List.Split

intToBool :: Int -> Bool
intToBool a
    | (a `mod` 5) == 0 = True
    | (a `mod` 5) /= 0 = False

{-
everyOther ::  [Char] -> Bool
everyOther [] = True
everyOther [x] = filter ([x] `elem` ['a'..'f'])

everyOther [] = True
everyOther (a:xa:xs)
    | filter (a `elem` ['a'..'f'])
-}
zipMap :: Num a => [a] -> [a] -> [a]
zipMap [] _ = []
zipMap _ [] = []
zipMap (x:xs) (y:ys) = (+) x y : zipMap xs ys

splitSpaces [] = []
splitSpaces (x:xs) = head (splitOn " " x) : splitSpaces xs

toTuples [] = []
toTuples (x:xy:xs) = (x,xy) : toTuples xs

tupleToProduct [] = []
tupleToProduct [(a,b)] = map (\(a,b) -> a * b) [(a,b)]

listToSum (x:xs) = scanl (+) x xs

applyThrice :: (Int -> Int) -> Int -> Int
applyThrice f x = f (f (f x))

{-
isLowerCase :: Char -> Bool
isLowerCase = elem . ['a'..'z']
-}
