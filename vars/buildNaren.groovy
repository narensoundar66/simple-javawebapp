def call(input)
{
 if( "${input}" == "hi")   //just printing hi if hi is input
 {
  echo "hello naren"
 }
 else if ("${input}" == "add")    //adding numbers if add is input
 {
  echo "doing addition"
  int x = input as int  //converting input to integer for adding
  int y = 6
  int ans = x + y      // can we use 6 explicitly
  echo "${ans}"
 }
}