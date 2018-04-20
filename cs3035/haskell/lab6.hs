
addTwo :: Int -> Int -> Int
addTwo x y = x + y

addTen :: Int -> Int -> Int
addTen x y = addTwo x y + 10

checkLowercase :: Char -> Bool
checkLowercase = (`elem`['a' .. 'z'])


applyThrice :: (a -> a) -> a -> a
applyThrice f x = f (f (f(x)))

everyOther :: (a -> a) -> [a] -> [a]
everyOther _ [] = []
everyOther f (x:xs:xy) = f x : everyOther f (xy)
everyOther f (x:xs) = f x : everyOther f (xs)

zipWith' :: (a -> b -> c -> d) -> [a] -> [b] -> [c] -> [d]
zipWith' _ [] _ _ = []
zipWith' _ _ [] _ = []
zipWith' _ _ _ [] = []
zipWith' f (x:xs) (y:ys) (z:zs) = f x y z : zipWith' f xs ys  zs


toTuple :: (Int -> Int) -> Int -> (Int,Int)
toTuple f x = (x, f x)

toMap ints f = ints f : map toTuple ints f
