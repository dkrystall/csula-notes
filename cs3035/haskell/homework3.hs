import System.Environment
import Data.List

data Student = Student {
firstname :: String,
lastName :: String,
major :: String,
age :: Int} deriving (Eq, Read, Show, Ord)

data Tree student = EmptyTree | Node Student (Tree student) (Tree student) deriving (Show, Read, Eq)


singleton :: Student -> Tree Student
singleton x = Node x EmptyTree EmptyTree

treeElem x EmptyTree = False
treeElem x (Node a left right)
    | x == a = True
    | x < a  = treeElem x left
    | x > a  = treeElem x right

treeInsert x EmptyTree = singleton x
treeInsert x (Node a left right)
    | x == a = Node x left right
    | x < a  = Node a (treeInsert x left) right
    | x > a  = Node a left (treeInsert x right)

dispatch :: [(String, [String] -> IO ())]
dispatch = [ ("readF", readF)]

main = do
    (command:args) <- getArgs
    let (Just action) = lookup command dispatch
    action args

readF :: [String] -> IO ()
readF [fileName] = do
    contents <- readFile fileName
    let cells = delimiter (==',') contents
    putStr $ unlines cells

delimiter :: (Char -> Bool) -> String -> [String]
delimiter f x =  case dropWhile f x of
            "" -> []
            x' -> w : delimiter f xs
                    where (w, xs) = break f x'
