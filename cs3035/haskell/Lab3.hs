sayHello :: String -> String
sayHello n = ("hello " ++ n )

subThreeInts :: Int -> Int -> Int -> Int
subThreeInts x y z = x-y-z

hypo :: Double -> Double -> Double
hypo a b = sqrt(a*a + b*b)

takeInNum :: Int -> Int -> Int
takeInNum a b = a+b

addFromString :: String -> Float
addFromString n = read n + 3.8 :: Float

takeInts :: Int -> [Char]
takeInts 1 = "Once"
takeInts 2 = "Twice"
takeInts 3 = "Thrice"
takeInts n = "Don't know how to say that in English."

quadOne :: a -> a -> a -> a -> a
quadOne w x y z = w

quadTwo :: b -> b -> b -> b -> b
quadTwo a b c d = b

quadThree :: c -> c -> c -> c -> c
quadThree h i j k = j

quadFour :: d -> d -> d -> d -> d
quadFour z y x w = w


powerMove :: Int -> Int -> Int
powermove 0 num = 1
powerMove pow num = num * powerMove (pow-1) num

mult :: (Num a) => [a] -> a
mult [] = 0
mult (x:y:z:rest) = x*y*z
mult (a:b:rest) = a*b
