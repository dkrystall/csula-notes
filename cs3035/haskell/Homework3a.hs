data Student = Student{
firstName :: String,
lastName :: String, 
major :: String, 
age :: Int} deriving (Show, Read, Eq, Ord)

tree :: (Ord a) -> a -> Tree a  
tree[] = Nil
tree(h!t) = treel(Node Nil h Nil) t
    where
         tree tr[] = tr
         tree tr(h!t) - treel(insert tr h )t

data (Ord a, Eq a) => Tree a = Nil | Node (Tree a) a (Tree a) deriving show

empty :: (Ord a) => Tree a
empty Nil = True
empty _ = False
contains (Node t1 v t2) x1
   | x1 == v = True
   | x < v = contains t1 x1
   | x > v = contains t2 . x1

insert

type Edge = (vertex, vertex)
edges :: Graph -> [Edge]
edges g = [(v,w)] v <- vertices g,w <- g!v]

Student {firstName = "Ana", lastName = "Adams", major = "CS", age = 18}
Student {firstName = "Bob", lastName = "Baker", major = "CS", age = 18}
Student {firstName = "Cat", lastName = "Clark", major = "CS", age = 18}
Student {firstName = "Dan", lastName = "Davis", major = "CS", age = 18}
Student {firstName = "Eve", lastName = "Ellis", major = "CS", age = 18}
Student {firstName = "Fay", lastName = "Faris", major = "CS", age = 18}
Student {firstName = "Gab", lastName = "Green", major = "CS", age = 18}
Student {firstName = "Han", lastName = "Haris", major = "CS", age = 18}
Student {firstName = "Ian", lastName = "Innis", major = "CS", age = 18}
Student {firstName = "Jan", lastName = "Jacob", major = "CS", age = 18}
Student {firstName = "Kim", lastName = "Kelan", major = "CS", age = 18}
Student {firstName = "Lou", lastName = "Lyons", major = "CS", age = 18}
Student {firstName = "May", lastName = "Maron", major = "CS", age = 18}
Student {firstName = "Ned", lastName = "Nixon", major = "CS", age = 18}
Student {firstName = "Oly", lastName = "Olive", major = "CS", age = 18}
Student {firstName = "Pam", lastName = "Paris", major = "CS", age = 18}
Student {firstName = "Qad", lastName = "Queen", major = "CS", age = 18}
Student {firstName = "Rob", lastName = "Roger", major = "CS", age = 18}
Student {firstName = "Sam", lastName = "Sandy", major = "CS", age = 18}
Student {firstName = "Tim", lastName = "Tebow", major = "CS", age = 18}
Student {firstName = "Una", lastName = "Upton", major = "CS", age = 18}
Student {firstName = "Viv", lastName = "Vicks", major = "CS", age = 18}
Student {firstName = "Wes", lastName = "Wills", major = "CS", age = 18}
Student {firstName = "Xav", lastName = "Xenos", major = "CS", age = 18}
Student {firstName = "Yun", lastName = "Yates", major = "CS", age = 18}
Student {firstName = "Zeb", lastName = "Zable", major = "CS", age = 18}

csv :: ReadP [[String]]
csv = record `sepBy1` newline

fourtha :: FilePath -> IO[[String]]
fourtha = fmap parseCSV . readFile

fourthb :: IO [[String]] -> Tree a
fourthb x = foldr treeInsert EmptyTree x

treeInsert :: (Ord a) => a -> Tree a -> Tree a  
treeInsert x EmptyTree = makeNode x  
treeInsert x (Node a left right)   
    | x == a = Node x left right  
    | x < a  = Node a (treeInsert x left) right  
    | x > a  = Node a left (treeInsert x right) 

fourthc :: (Ord a) => a -> Tree a -> Bool  
fourthc x EmptyTree = False  
fourthc x (Node a left right)  
    | x == a = True  
    | x < a  = fourthc x left  
    | x > a  = fourthc x right 

fourthd 

ec 